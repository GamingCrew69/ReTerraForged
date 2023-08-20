/*
 *
 * MIT License
 *
 * Copyright (c) 2020 TerraForged
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package raccoonman.reterraforged.common.noise.domain;

import java.util.function.Function;

import com.mojang.serialization.Codec;

import raccoonman.reterraforged.common.noise.Noise;
import raccoonman.reterraforged.common.noise.Source;
import raccoonman.reterraforged.common.registries.RTFBuiltInRegistries;

public interface Domain {
	public static final Codec<Domain> CODEC = RTFBuiltInRegistries.DOMAIN_TYPE.byNameCodec().dispatchStable(Domain::codec, Function.identity());

    float getOffsetX(float x, float y, int seed);

    float getOffsetY(float x, float y, int seed);

    Codec<? extends Domain> codec();
    
    default float getX(float x, float y, int seed) {
        return x + getOffsetX(x, y, seed);
    }

    default float getY(float x, float y, int seed) {
        return y + getOffsetY(x, y, seed);
    }

    default Domain cache() {
        return new CacheWarp(this);
    }

    default Domain shift(int shift) {
    	return new ShiftWarp(this, shift);
    }
    
    default Domain add(Domain next) {
        return new AddWarp(this, next);
    }

    default Domain warp(Domain next) {
        return new CompoundWarp(this, next);
    }

    default Domain then(Domain next) {
        return new CumulativeWarp(this, next);
    }

    public static Domain warp(Noise x, Noise y, Noise distance) {
        return new DomainWarp(x, y, distance);
    }

    public static Domain warp(int scale, int octaves, double strength) {
        return warp(Source.PERLIN, scale, octaves, strength);
    }

    public static Domain warp(Source type, int scale, int octaves, double strength) {
        return warp(
        	Source.build(scale, octaves).build(type).shift(0),
        	Source.build(scale, octaves).build(type).shift(1),
        	Source.constant(strength)
        );
    }

    public static Domain direction(Noise direction, Noise distance) {
        return new DirectionWarp(direction, distance);
    }

    public static Domain direction(int shift, int scale, int octaves, double strength) {
        return direction(Source.PERLIN, shift, scale, octaves, strength);
    }

    public static Domain direction(Source type, int shift, int scale, int octaves, double strength) {
        return direction(
        	Source.build(scale, octaves).build(type).shift(shift),
        	Source.constant(strength)
        );
    }
}
