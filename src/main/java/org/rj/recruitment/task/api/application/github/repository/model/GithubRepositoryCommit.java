package org.rj.recruitment.task.api.application.github.repository.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GithubRepositoryCommit {
    @JsonProperty("sha")
    private String lastCommitSHA;
}
