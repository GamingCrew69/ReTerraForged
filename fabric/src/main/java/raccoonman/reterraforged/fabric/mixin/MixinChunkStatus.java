package raccoonman.reterraforged.fabric.mixin;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;

import net.minecraft.world.level.chunk.status.ChunkStatusTasks;
import net.minecraft.world.level.chunk.status.ToFullChunk;
import net.minecraft.world.level.chunk.status.WorldGenContext;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.chunk.ChunkAccess;
import net.minecraft.world.level.chunk.status.ChunkStatus;
import net.minecraft.world.level.levelgen.RandomState;
import raccoonman.reterraforged.world.worldgen.GeneratorContext;
import raccoonman.reterraforged.world.worldgen.RTFRandomState;

@Mixin(ChunkStatusTasks.class)
public class MixinChunkStatus {

	@Inject(
		at = @At("HEAD"),
		method = "generateStructureStarts",
		require = 1
	)
	private static void generateStructureStarts(WorldGenContext worldGenContext, ChunkStatus chunkStatus, Executor executor, ToFullChunk toFullChunk, List<ChunkAccess> list, ChunkAccess chunkAccess,  CallbackInfoReturnable<CompletableFuture<ChunkAccess>> callback) {
		RandomState randomState = worldGenContext.level().getChunkSource().randomState();
		if((Object) randomState instanceof RTFRandomState rtfRandomState) {
			ChunkPos chunkPos = chunkAccess.getPos();
			@Nullable
			GeneratorContext context = rtfRandomState.generatorContext();
			
			if(context != null) {
				context.cache.queueAtChunk(chunkPos.x, chunkPos.z);
			}
		}
	}
	
	@Inject(
		at = @At("TAIL"),
		method = "generateFeatures",
		require = 1
	)
	private static void generateFeatures(WorldGenContext worldGenContext, ChunkStatus chunkStatus, Executor executor, ToFullChunk toFullChunk, List<ChunkAccess> list, ChunkAccess chunkAccess, CallbackInfoReturnable<CompletableFuture<ChunkAccess>> callback) {
		RandomState randomState = worldGenContext.level().getChunkSource().randomState();
		if((Object) randomState instanceof RTFRandomState rtfRandomState) {
			ChunkPos chunkPos = chunkAccess.getPos();
			@Nullable
			GeneratorContext context = rtfRandomState.generatorContext();
			
			if(context != null) {
				context.cache.dropAtChunk(chunkPos.x, chunkPos.z);
			}
		}
	}
}
