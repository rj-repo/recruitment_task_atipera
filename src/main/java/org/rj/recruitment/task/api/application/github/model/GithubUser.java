package org.rj.recruitment.task.api.application.github.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.rj.recruitment.task.api.application.github.repository.model.GithubRepositoryBranch;
import org.rj.recruitment.task.api.domain.model.RepositoryUser;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@Builder
public class GithubUser {
    private String username;
    private String repoName;
    private List<GithubRepositoryBranch> branches;


    public static RepositoryUser toModel(GithubUser user) {
        return RepositoryUser.builder()
                .repoName(user.getRepoName())
                .branches(user.getBranches().stream().map(GithubRepositoryBranch::toModel).collect(Collectors.toList()))
                .build();
    }
}
