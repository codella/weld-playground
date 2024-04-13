package org.gradle.accessors.dm;

import org.gradle.api.NonNullApi;
import org.gradle.api.artifacts.MinimalExternalModuleDependency;
import org.gradle.plugin.use.PluginDependency;
import org.gradle.api.artifacts.ExternalModuleDependencyBundle;
import org.gradle.api.artifacts.MutableVersionConstraint;
import org.gradle.api.provider.Provider;
import org.gradle.api.model.ObjectFactory;
import org.gradle.api.provider.ProviderFactory;
import org.gradle.api.internal.catalog.AbstractExternalDependencyFactory;
import org.gradle.api.internal.catalog.DefaultVersionCatalog;
import java.util.Map;
import org.gradle.api.internal.attributes.ImmutableAttributesFactory;
import org.gradle.api.internal.artifacts.dsl.CapabilityNotationParser;
import javax.inject.Inject;

/**
 * A catalog of dependencies accessible via the {@code libs} extension.
 */
@NonNullApi
public class LibrariesForLibs extends AbstractExternalDependencyFactory {

    private final AbstractExternalDependencyFactory owner = this;
    private final FloggerLibraryAccessors laccForFloggerLibraryAccessors = new FloggerLibraryAccessors(owner);
    private final JunitLibraryAccessors laccForJunitLibraryAccessors = new JunitLibraryAccessors(owner);
    private final SmallryeLibraryAccessors laccForSmallryeLibraryAccessors = new SmallryeLibraryAccessors(owner);
    private final WeldLibraryAccessors laccForWeldLibraryAccessors = new WeldLibraryAccessors(owner);
    private final VersionAccessors vaccForVersionAccessors = new VersionAccessors(providers, config);
    private final BundleAccessors baccForBundleAccessors = new BundleAccessors(objects, providers, config, attributesFactory, capabilityNotationParser);
    private final PluginAccessors paccForPluginAccessors = new PluginAccessors(providers, config);

    @Inject
    public LibrariesForLibs(DefaultVersionCatalog config, ProviderFactory providers, ObjectFactory objects, ImmutableAttributesFactory attributesFactory, CapabilityNotationParser capabilityNotationParser) {
        super(config, providers, objects, attributesFactory, capabilityNotationParser);
    }

    /**
     * Dependency provider for <b>guava</b> with <b>com.google.guava:guava</b> coordinates and
     * with version reference <b>guava</b>
     * <p>
     * This dependency was declared in catalog libs.versions.toml
     */
    public Provider<MinimalExternalModuleDependency> getGuava() {
        return create("guava");
    }

    /**
     * Group of libraries at <b>flogger</b>
     */
    public FloggerLibraryAccessors getFlogger() {
        return laccForFloggerLibraryAccessors;
    }

    /**
     * Group of libraries at <b>junit</b>
     */
    public JunitLibraryAccessors getJunit() {
        return laccForJunitLibraryAccessors;
    }

    /**
     * Group of libraries at <b>smallrye</b>
     */
    public SmallryeLibraryAccessors getSmallrye() {
        return laccForSmallryeLibraryAccessors;
    }

    /**
     * Group of libraries at <b>weld</b>
     */
    public WeldLibraryAccessors getWeld() {
        return laccForWeldLibraryAccessors;
    }

    /**
     * Group of versions at <b>versions</b>
     */
    public VersionAccessors getVersions() {
        return vaccForVersionAccessors;
    }

    /**
     * Group of bundles at <b>bundles</b>
     */
    public BundleAccessors getBundles() {
        return baccForBundleAccessors;
    }

    /**
     * Group of plugins at <b>plugins</b>
     */
    public PluginAccessors getPlugins() {
        return paccForPluginAccessors;
    }

    public static class FloggerLibraryAccessors extends SubDependencyFactory implements DependencyNotationSupplier {
        private final FloggerSystemLibraryAccessors laccForFloggerSystemLibraryAccessors = new FloggerSystemLibraryAccessors(owner);

        public FloggerLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>flogger</b> with <b>com.google.flogger:flogger</b> coordinates and
         * with version reference <b>flogger</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> asProvider() {
            return create("flogger");
        }

        /**
         * Group of libraries at <b>flogger.system</b>
         */
        public FloggerSystemLibraryAccessors getSystem() {
            return laccForFloggerSystemLibraryAccessors;
        }

    }

    public static class FloggerSystemLibraryAccessors extends SubDependencyFactory {

        public FloggerSystemLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>backend</b> with <b>com.google.flogger:flogger-system-backend</b> coordinates and
         * with version reference <b>flogger</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getBackend() {
            return create("flogger.system.backend");
        }

    }

    public static class JunitLibraryAccessors extends SubDependencyFactory {

        public JunitLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>jupiter</b> with <b>org.junit.jupiter:junit-jupiter</b> coordinates and
         * with version reference <b>junit.jupiter</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getJupiter() {
            return create("junit.jupiter");
        }

    }

    public static class SmallryeLibraryAccessors extends SubDependencyFactory {

        public SmallryeLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>config</b> with <b>io.smallrye.config:smallrye-config</b> coordinates and
         * with version reference <b>smallrye</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getConfig() {
            return create("smallrye.config");
        }

    }

    public static class WeldLibraryAccessors extends SubDependencyFactory {
        private final WeldSeLibraryAccessors laccForWeldSeLibraryAccessors = new WeldSeLibraryAccessors(owner);

        public WeldLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>weld.se</b>
         */
        public WeldSeLibraryAccessors getSe() {
            return laccForWeldSeLibraryAccessors;
        }

    }

    public static class WeldSeLibraryAccessors extends SubDependencyFactory {

        public WeldSeLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>core</b> with <b>org.jboss.weld.se:weld-se-core</b> coordinates and
         * with version reference <b>weld.se</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getCore() {
            return create("weld.se.core");
        }

    }

    public static class VersionAccessors extends VersionFactory  {

        private final JunitVersionAccessors vaccForJunitVersionAccessors = new JunitVersionAccessors(providers, config);
        private final WeldVersionAccessors vaccForWeldVersionAccessors = new WeldVersionAccessors(providers, config);
        public VersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Version alias <b>flogger</b> with value <b>0.8</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getFlogger() { return getVersion("flogger"); }

        /**
         * Version alias <b>guava</b> with value <b>32.1.3-jre</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getGuava() { return getVersion("guava"); }

        /**
         * Version alias <b>smallrye</b> with value <b>3.7.1</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getSmallrye() { return getVersion("smallrye"); }

        /**
         * Group of versions at <b>versions.junit</b>
         */
        public JunitVersionAccessors getJunit() {
            return vaccForJunitVersionAccessors;
        }

        /**
         * Group of versions at <b>versions.weld</b>
         */
        public WeldVersionAccessors getWeld() {
            return vaccForWeldVersionAccessors;
        }

    }

    public static class JunitVersionAccessors extends VersionFactory  {

        public JunitVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Version alias <b>junit.jupiter</b> with value <b>5.10.0</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getJupiter() { return getVersion("junit.jupiter"); }

    }

    public static class WeldVersionAccessors extends VersionFactory  {

        public WeldVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Version alias <b>weld.se</b> with value <b>6.0.0.Beta1</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getSe() { return getVersion("weld.se"); }

    }

    public static class BundleAccessors extends BundleFactory {

        public BundleAccessors(ObjectFactory objects, ProviderFactory providers, DefaultVersionCatalog config, ImmutableAttributesFactory attributesFactory, CapabilityNotationParser capabilityNotationParser) { super(objects, providers, config, attributesFactory, capabilityNotationParser); }

    }

    public static class PluginAccessors extends PluginFactory {

        public PluginAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

    }

}