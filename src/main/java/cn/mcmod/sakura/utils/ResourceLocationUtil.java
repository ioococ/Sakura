package cn.mcmod.sakura.utils;

import cn.mcmod.sakura.Sakura;
import net.minecraft.resources.ResourceLocation;

import java.util.Locale;

/**
 * @author uiYzzi
 * @date 07/12/2024 12:37
 * @version 1.0
 */
public class ResourceLocationUtil {

    public static ResourceLocation prefix(String name) {
        return new ResourceLocation(Sakura.MOD_ID, "spawn_egg/" + name.toLowerCase(Locale.ROOT));
    }

    public static ResourceLocation bottle(String name) {
        return new ResourceLocation(Sakura.MOD_ID, "bottle/" + name.toLowerCase(Locale.ROOT));
    }

    public static ResourceLocation cup(String name) {
        return new ResourceLocation(Sakura.MOD_ID, "cup/" + name.toLowerCase(Locale.ROOT));
    }

    public static ResourceLocation tea(String name) {
        return new ResourceLocation(Sakura.MOD_ID, "tea/" + name.toLowerCase(Locale.ROOT));
    }

    public static ResourceLocation juice(String name) {
        return new ResourceLocation(Sakura.MOD_ID, "juice/" + name.toLowerCase(Locale.ROOT));
    }

    public static ResourceLocation modelTexture(String name) {
        return new ResourceLocation(Sakura.MOD_ID, "textures/models/mob/" + name);
    }

    public static ResourceLocation chimeTexture(String name) {
        return new ResourceLocation(Sakura.MOD_ID, "block/chime/" + name);
    }

    public static ResourceLocation item(String name) {
        return new ResourceLocation(Sakura.MOD_ID, name);
    }

    public static ResourceLocation gui(String name) {
        return new ResourceLocation(Sakura.MOD_ID, "textures/gui/" + name);
    }

    public static ResourceLocation res(String name) {
        return new ResourceLocation(Sakura.MOD_ID, name);
    }
}