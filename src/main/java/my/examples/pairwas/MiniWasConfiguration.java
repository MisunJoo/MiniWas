package my.examples.pairwas;

//값만 저장되는 객체 : ValueObejct (VO) : 값을 보관하는 목적
// :DataTransformObject (DTO) : 값을 주고받기 위한 목적
public class MiniWasConfiguration {
    private String staticDir;
    private String classPath;

    public String getStaticDir() {
        return staticDir;
    }

    public void setStaticDir(String staticDir) {
        this.staticDir = staticDir;
    }

    public String getClassPath() {
        return classPath;
    }

    public void setClassPath(String classPath) {
        this.classPath = classPath;
    }
}
