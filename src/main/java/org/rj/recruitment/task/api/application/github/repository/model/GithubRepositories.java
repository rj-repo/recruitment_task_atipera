package org.rj.recruitment.task.api.application.github.repository.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@Accessors(chain = true)
public class GithubRepositories {

    private List<GithubRepository> githubRepositoryList;


    public GithubRepositories getOnlyNotForkRepos() {
        List<GithubRepository> list = githubRepositoryList.stream()
                .filter(r -> !r.isFork())
                .toList();

        return this.setGithubRepositoryList(list);


    }
}
