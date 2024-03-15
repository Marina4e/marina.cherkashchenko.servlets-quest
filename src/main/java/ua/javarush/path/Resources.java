package ua.javarush.path;

import lombok.Getter;

import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;

@Getter
public class Resources {
    private final String pathToJsonProp;
    private final String pathToRes;
    private final String pathToSessionInfo;

    public Resources() {
        String pathRes = URLDecoder.decode(Resources.class
                .getProtectionDomain()
                .getCodeSource()
                .getLocation()
                .getPath(), StandardCharsets.UTF_8).substring(1);
        pathToRes = pathRes;
        pathToJsonProp = pathToRes + "stepsInfo.json";
        pathToSessionInfo = pathToRes.substring(0, pathRes.indexOf("classes"))
                + "session_info.jsp";
    }
}
