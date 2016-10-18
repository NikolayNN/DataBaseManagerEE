package my.project.juja.service;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Nikol on 10/10/2016.
 */
public class ServiceImpl implements Service {
    @Override
    public List<String> commandList() {
        return Arrays.asList("help", "menu", "connect");
    }
}
