package cn.mcmod.sakura.data;

import cn.mcmod.sakura.fluid.FluidInfo;
import com.google.gson.JsonObject;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.DataProvider;
import net.minecraft.data.HashCache;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.nio.file.Path;

import static cn.mcmod.sakura.Sakura.GSON;

public class SakuraAnimationMetadataProvider implements DataProvider {
    private final DataGenerator generator;
    private final String modId;

    public SakuraAnimationMetadataProvider(DataGenerator generator, String modId) {
        this.generator = generator;
        this.modId = modId;
    }

    @Override
    public void run(@NotNull HashCache cache) throws IOException {
        for (FluidInfo fluidInfo : FluidInfo.values()) {

            mcmeta(cache, "block/" + fluidInfo.key + "_still", getFrameTime(fluidInfo.tickRate));
            mcmeta(cache, "block/" + fluidInfo.key + "_flow", getFrameTime(fluidInfo.tickRate));
        }

    }

    private void mcmeta(HashCache cache, String name, Integer frametime) throws IOException {
        ResourceLocation textureId = new ResourceLocation(modId, name);

        Path targetPath = this.generator.getOutputFolder()
                .resolve("assets")
                .resolve(textureId.getNamespace())
                .resolve("textures")
                .resolve(textureId.getPath() + ".png.mcmeta");

        // 构建 mcmeta 的 JSON 结构
        JsonObject root = new JsonObject();
        JsonObject animation = new JsonObject();

        animation.addProperty("frametime", frametime);
        animation.addProperty("interpolate", false);

        root.add("animation", animation);

        DataProvider.save(GSON, cache, root, targetPath);
    }

    public static int getFrameTime(int tickRate) {
        if (tickRate <= 3) return 1;
        int score = 1 + (9 * (tickRate - 3) + 8) / 17;
        return Math.min(10, score);
    }

    @Override
    public String getName() {
        return "Sakura Animation Metadata Generator";
    }
}