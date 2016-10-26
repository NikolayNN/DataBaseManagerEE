package my.project.juja.service;

import java.util.List;

/**
 * Created by Nikol on 10/10/2016.
 */
public interface Service {
    void connect(String serverURL, String userName, String password);

    List<String> commandList();
}
