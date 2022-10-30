package models;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Environment {
    Map<String, EnvironmentModel> environments = new LinkedHashMap<>();

    @JsonAnySetter
    void setEnvironment(String key, EnvironmentModel environmentModel) {
        environments.put(key, environmentModel);
    }

    @JsonAnyGetter
    public List<EnvironmentModel> getEnvironments() {
        return environments.values().stream().toList();
    }
}
