package cn.mcmod.sakura.client.sound;

import cn.mcmod.sakura.Sakura;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class SoundRegistry {
    public static final DeferredRegister<SoundEvent> SOUND_EVENT = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, Sakura.MOD_ID);

    public static final RegistryObject<SoundEvent> LEAVES_BREAK = SoundRegistry.registerSoundEvent("leaves_break");
    public static final RegistryObject<SoundEvent> LEAVES_STEP = registerSoundEvent("leaves_step");
    public static final RegistryObject<SoundEvent> LEAVES_PLACE = registerSoundEvent("leaves_place");
    public static final RegistryObject<SoundEvent> LEAVES_HIT = registerSoundEvent("leaves_hit");
    public static final RegistryObject<SoundEvent> LEAVES_FALL = registerSoundEvent("leaves_fall");

    private static RegistryObject<SoundEvent> registerSoundEvent(String name) {
        return SOUND_EVENT.register(
                name,
                () -> new SoundEvent(new ResourceLocation(Sakura.MOD_ID, name))
        );
    }

    public static void register(IEventBus eventBus) {
        SOUND_EVENT.register(eventBus);
    }
}