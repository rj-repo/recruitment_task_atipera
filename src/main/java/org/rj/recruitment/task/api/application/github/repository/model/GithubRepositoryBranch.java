package org.rj.recruitment.task.api.application.github.repository.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import org.rj.recruitment.task.api.domain.model.RepositoryBranch;

@Getter
@Setter
public class GithubRepositoryBranch {
    private String name;
    @JsonProperty(value = "commit")
    private GithubRepositoryCommit commit;

    public static RepositoryBranch toModel(GithubRepositoryBranch githubRepositoryBranch) {
        return RepositoryBranch
                .builder()
                .branchName(githubRepositoryBranch.getName())
                .lastCommitSHA(githubRepositoryBranch.getCommit().getLastCommitSHA())
                .build();
    }
}
