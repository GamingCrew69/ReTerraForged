package raccoonman.reterraforged.world.worldgen.biome.modifier;

import java.util.function.Function;

import com.mojang.serialization.Codec;

import com.mojang.serialization.MapCodec;
import raccoonman.reterraforged.registries.RTFBuiltInRegistries;

// theres other worldgen libraries we can use for this that aren't so janky
@Deprecated(forRemoval = true)
public interface BiomeModifier {
    public static final Codec<BiomeModifier> CODEC = RTFBuiltInRegistries.BIOME_MODIFIER_TYPE.byNameCodec().dispatch(BiomeModifier::codec, Function.identity());
	
	MapCodec<? extends BiomeModifier> codec();
}
