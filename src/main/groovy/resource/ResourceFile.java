package resource;

import java.net.URL;
/**
 * A very simple class for obtaining resources via the {@link java.lang.ClassLoader}
 * object in any class without having to obtain the {@link java.lang.ClassLoader}
 * each time. An abstraction and a convenience class for the
 * purpose of accessing resource files on the current classpath.
 * @author Jeremy
 */
public class ResourceFile {
    private ClassLoader classLoader;
    /**
     * The string name of the resource file on the current
     * classpath that includes its extension, but
     * excludes any path segments, relative or absolute
     */
    private String fileName;
    /**
     * The general constructor. Initializes its own {@link java.lang.ClassLoader}
     * with with to obtain the resource from the current classpath
     * @param fileName See {@link resource.ResourceFile#fileName}
     */
    public ResourceFile(String fileName) {
        this.classLoader = this.getClass().getClassLoader();
        this.fileName = fileName;
    }
    /**
     * Obtain a {@link java.net.URL} representing the file resource on the current
     * classpath corresponding to the current {@link resource.ResourceFile#fileName}
     * @return {@link java.net.URL} obtained via {@link java.lang.ClassLoader#getResource}
     * using {@link resource.ResourceFile#fileName} for the parameter
     */
    public URL getUrl() {
        return this.classLoader.getResource(this.fileName);
    }

}