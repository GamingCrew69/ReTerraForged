package raccoonman.reterraforged.common.registries;

import com.mojang.serialization.Codec;

import raccoonman.reterraforged.common.level.levelgen.noise.HolderNoise;
import raccoonman.reterraforged.common.level.levelgen.noise.Noise;
import raccoonman.reterraforged.common.level.levelgen.noise.climate.Moisture;
import raccoonman.reterraforged.common.level.levelgen.noise.climate.Temperature;
import raccoonman.reterraforged.common.level.levelgen.noise.combiner.Add;
import raccoonman.reterraforged.common.level.levelgen.noise.combiner.Div;
import raccoonman.reterraforged.common.level.levelgen.noise.combiner.Max;
import raccoonman.reterraforged.common.level.levelgen.noise.combiner.Min;
import raccoonman.reterraforged.common.level.levelgen.noise.combiner.Mul;
import raccoonman.reterraforged.common.level.levelgen.noise.combiner.Sub;
import raccoonman.reterraforged.common.level.levelgen.noise.modifier.Abs;
import raccoonman.reterraforged.common.level.levelgen.noise.modifier.AdvancedTerrace;
import raccoonman.reterraforged.common.level.levelgen.noise.modifier.Alpha;
import raccoonman.reterraforged.common.level.levelgen.noise.modifier.Bias;
import raccoonman.reterraforged.common.level.levelgen.noise.modifier.Boost;
import raccoonman.reterraforged.common.level.levelgen.noise.modifier.Clamp;
import raccoonman.reterraforged.common.level.levelgen.noise.modifier.Curve;
import raccoonman.reterraforged.common.level.levelgen.noise.modifier.Freq;
import raccoonman.reterraforged.common.level.levelgen.noise.modifier.Grad;
import raccoonman.reterraforged.common.level.levelgen.noise.modifier.Invert;
import raccoonman.reterraforged.common.level.levelgen.noise.modifier.LegacyTerrace;
import raccoonman.reterraforged.common.level.levelgen.noise.modifier.Map;
import raccoonman.reterraforged.common.level.levelgen.noise.modifier.Modulate;
import raccoonman.reterraforged.common.level.levelgen.noise.modifier.Negate;
import raccoonman.reterraforged.common.level.levelgen.noise.modifier.Power;
import raccoonman.reterraforged.common.level.levelgen.noise.modifier.PowerCurve;
import raccoonman.reterraforged.common.level.levelgen.noise.modifier.Round;
import raccoonman.reterraforged.common.level.levelgen.noise.modifier.Scale;
import raccoonman.reterraforged.common.level.levelgen.noise.modifier.Shift;
import raccoonman.reterraforged.common.level.levelgen.noise.modifier.Steps;
import raccoonman.reterraforged.common.level.levelgen.noise.modifier.Terrace;
import raccoonman.reterraforged.common.level.levelgen.noise.modifier.Threshold;
import raccoonman.reterraforged.common.level.levelgen.noise.modifier.VariableCurve;
import raccoonman.reterraforged.common.level.levelgen.noise.modifier.Warp;
import raccoonman.reterraforged.common.level.levelgen.noise.selector.Base;
import raccoonman.reterraforged.common.level.levelgen.noise.selector.Blend;
import raccoonman.reterraforged.common.level.levelgen.noise.selector.MultiBlend;
import raccoonman.reterraforged.common.level.levelgen.noise.selector.Select;
import raccoonman.reterraforged.common.level.levelgen.noise.selector.VariableBlend;
import raccoonman.reterraforged.common.level.levelgen.noise.source.Billow;
import raccoonman.reterraforged.common.level.levelgen.noise.source.Cell;
import raccoonman.reterraforged.common.level.levelgen.noise.source.CellEdge;
import raccoonman.reterraforged.common.level.levelgen.noise.source.Constant;
import raccoonman.reterraforged.common.level.levelgen.noise.source.Cubic;
import raccoonman.reterraforged.common.level.levelgen.noise.source.Perlin;
import raccoonman.reterraforged.common.level.levelgen.noise.source.Perlin2;
import raccoonman.reterraforged.common.level.levelgen.noise.source.Rand;
import raccoonman.reterraforged.common.level.levelgen.noise.source.Ridge;
import raccoonman.reterraforged.common.level.levelgen.noise.source.Simplex;
import raccoonman.reterraforged.common.level.levelgen.noise.source.Simplex2;
import raccoonman.reterraforged.common.level.levelgen.noise.source.SimplexRidge;
import raccoonman.reterraforged.common.level.levelgen.noise.source.Sin;
import raccoonman.reterraforged.platform.registries.RegistryUtil;

public final class RTFNoiseTypes {
	
	public static void bootstrap() {
		register("holder", HolderNoise.CODEC);
		register("constant", Constant.CODEC);
		register("billow", Billow.CODEC);
		register("cell", Cell.CODEC);
		register("cell_edge", CellEdge.CODEC);
		register("cubic", Cubic.CODEC);
		register("perlin", Perlin.CODEC);
		register("perlin2", Perlin2.CODEC);
		register("ridge", Ridge.CODEC);
		register("simplex", Simplex.CODEC);
		register("simplex2", Simplex2.CODEC);
		register("simplex_ridge", SimplexRidge.CODEC);
		register("sin", Sin.CODEC);
		register("rand", Rand.CODEC);
		register("add", Add.CODEC);
		register("max", Max.CODEC);
		register("min", Min.CODEC);
		register("mul", Mul.CODEC);
		register("div", Div.CODEC);
		register("sub", Sub.CODEC);
		register("abs", Abs.CODEC);
		register("advanced_terrace", AdvancedTerrace.CODEC);
		register("alpha", Alpha.CODEC);
		register("bias", Bias.CODEC);
		register("boost", Boost.CODEC);
		register("clamp", Clamp.CODEC);
		register("curve", Curve.CODEC);
		register("freq", Freq.CODEC);
		register("grad", Grad.CODEC);
		register("invert", Invert.CODEC);
		register("legacy_terrace", LegacyTerrace.CODEC);
		register("map", Map.CODEC);
		register("modulate", Modulate.CODEC);
		register("power", Power.CODEC);
		register("power_curve", PowerCurve.CODEC);
		register("round", Round.CODEC);
		register("scale", Scale.CODEC);
		register("shift", Shift.CODEC);
		register("steps", Steps.CODEC);
		register("terrace", Terrace.CODEC);
		register("variable_curve", VariableCurve.CODEC);
		register("warp", Warp.CODEC);
		register("base", Base.CODEC);
		register("blend", Blend.CODEC);
		register("multi_blend", MultiBlend.CODEC);
		register("select", Select.CODEC);
		register("variable_blend", VariableBlend.CODEC);
		register("threshold", Threshold.CODEC);
		register("negate", Negate.CODEC);
		register("temperature", Temperature.CODEC);
		register("moisture", Moisture.CODEC);
	}
	
	private static void register(String name, Codec<? extends Noise> value) {
		RegistryUtil.register(RTFBuiltInRegistries.NOISE_TYPE, name, value);
	}
}