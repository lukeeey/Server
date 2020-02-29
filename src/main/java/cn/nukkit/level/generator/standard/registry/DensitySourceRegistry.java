package cn.nukkit.level.generator.standard.registry;

import cn.nukkit.event.Event;
import cn.nukkit.event.HandlerList;
import cn.nukkit.level.generator.standard.gen.density.DensitySource;
import cn.nukkit.level.generator.standard.gen.density.VanillaDensitySource;
import cn.nukkit.utils.Identifier;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import net.daporkchop.lib.noise.NoiseSource;

/**
 * Registry for {@link NoiseSource}.
 *
 * @author DaPorkchop_
 * @see StandardGeneratorRegistries#noiseSource()
 */
@NoArgsConstructor(access = AccessLevel.PACKAGE)
public final class DensitySourceRegistry extends AbstractGeneratorRegistry<DensitySource> {
    @Override
    protected void registerDefault() {
        this.register(Identifier.fromString("nukkitx:vanilla"), VanillaDensitySource.class);
    }

    @Override
    protected Event constructionEvent() {
        return new ConstructionEvent(this);
    }

    @RequiredArgsConstructor(access = AccessLevel.PRIVATE)
    public static final class ConstructionEvent extends Event {
        @Getter
        private static HandlerList handlers = new HandlerList();

        @NonNull
        private final DensitySourceRegistry registry;

        public DensitySourceRegistry getRegistry() {
            return this.registry;
        }
    }
}
