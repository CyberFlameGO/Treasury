package me.lokka30.treasury.plugin.core;

import java.util.List;
import java.util.Objects;
import me.lokka30.treasury.api.economy.EconomyProvider;
import me.lokka30.treasury.api.economy.misc.EconomyAPIVersion;
import me.lokka30.treasury.plugin.core.config.ConfigAdapter;
import me.lokka30.treasury.plugin.core.config.messaging.ColorHandler;
import me.lokka30.treasury.plugin.core.logging.Logger;
import me.lokka30.treasury.plugin.core.schedule.Scheduler;
import org.jetbrains.annotations.NotNull;

/**
 * Treasury core implementations must implement this class and set its instance in order for the core
 * to function properly.
 *
 * @author MrIvanPlays
 * @since v1.0.0
 */
public abstract class TreasuryPlugin {

    private static TreasuryPlugin instance;

    /**
     * Returns the instance set for this class.
     *
     * @return instance
     */
    public static TreasuryPlugin getInstance() {
        return instance;
    }

    /**
     * Sets an instance for this treasury plugin.
     *
     * @param newInstance the instance set
     * @throws IllegalArgumentException if instance is already set
     */
    public static void setInstance(@NotNull TreasuryPlugin newInstance) {
        Objects.requireNonNull(newInstance, "newInstance");
        if (instance != null) {
            throw new IllegalArgumentException("Instance already set");
        }
        instance = newInstance;
    }

    /**
     * Returns the version of the treasury plugin.
     *
     * @return version
     */
    @NotNull
    public abstract String getVersion();

    /**
     * Returns the description of the treasury plugin.
     *
     * @return description
     */
    @NotNull
    public abstract String getDescription();

    /**
     * Returns the first {@link ProviderEconomy}
     *
     * @return highest priority provider of economy provider
     */
    @NotNull
    public ProviderEconomy economyProviderProvider() {
        return allProviders().get(0);
    }

    /**
     * Should give all the economy providers registered, ordered by highest priority.
     *
     * @return ordered providers list
     */
    @NotNull
    public abstract List<ProviderEconomy> allProviders();

    /**
     * Should register the specified {@link EconomyProvider} at the highest priority.
     *
     * @param newProvider provider to register
     */
    public abstract void registerProvider(@NotNull EconomyProvider newProvider);

    /**
     * Should re register the specified {@link ProviderEconomy} at the priority defined by the {@code lowPriority}
     * param.
     *
     * @param provider the provider to re register
     * @param lowPriority should register on low priority
     */
    public abstract void reregisterProvider(@NotNull ProviderEconomy provider, boolean lowPriority);

    /**
     * Should unregister the specified {@link EconomyProvider}
     *
     * @param provider provider to unregister
     */
    public abstract void unregisterProvider(@NotNull EconomyProvider provider);

    /**
     * Returns the logger wrapper.
     *
     * @return logger
     */
    @NotNull
    public abstract Logger logger();

    /**
     * Returns the scheduler wrapper.
     *
     * @return scheduler
     */
    @NotNull
    public abstract Scheduler scheduler();

    /**
     * Returns the config adapter.
     *
     * @return config adapter
     */
    @NotNull
    public abstract ConfigAdapter configAdapter();

    /**
     * Returns handling of colors.
     *
     * @return color handling
     */
    @NotNull
    public abstract ColorHandler colorHandler();

    /**
     * Should reload the plugin
     */
    public abstract void reload();

    /**
     * Returns the treasury api version
     *
     * @return treasury api version
     */
    @NotNull
    public abstract EconomyAPIVersion getEconomyAPIVersion();
}
