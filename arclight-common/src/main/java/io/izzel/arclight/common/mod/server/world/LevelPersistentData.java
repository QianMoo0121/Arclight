package io.izzel.arclight.common.mod.server.world;

import io.izzel.arclight.common.mod.ArclightConstants;
import net.minecraft.core.HolderLookup;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.level.saveddata.SavedData;
import org.bukkit.craftbukkit.v.CraftWorld;
import org.jetbrains.annotations.NotNull;

public class LevelPersistentData extends SavedData {

    private CompoundTag tag;

    public LevelPersistentData(CompoundTag tag, HolderLookup.Provider provider) {
        this.tag = tag == null ? new CompoundTag() : tag;
    }

    public CompoundTag getTag() {
        return tag;
    }

    public void save(CraftWorld world) {
        this.tag = new CompoundTag();
        world.storeBukkitValues(this.tag);
    }

    @Override
    public @NotNull CompoundTag save(@NotNull CompoundTag it, @NotNull HolderLookup.Provider provider) {
        return tag;
    }

    public static Factory<LevelPersistentData> factory() {
        return new SavedData.Factory<>(() -> new LevelPersistentData(null, null), LevelPersistentData::new, ArclightConstants.BUKKIT_PDC);
    }
}
