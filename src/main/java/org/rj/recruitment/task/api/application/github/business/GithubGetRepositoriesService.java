package org.rj.recruitment.task.api.application.github.business;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.rj.recruitment.task.api.application.github.model.GithubUser;
import org.rj.recruitment.task.api.application.github.repository.model.GithubRepositories;
import org.rj.recruitment.task.api.domain.business.ExternalApiGetService;
import org.rj.recruitment.task.api.domain.model.RepositoriesUser;
import org.rj.recruitment.task.api.domain.model.RepositoryUser;

import java.util.List;

@ApplicationScoped
public class GithubGetRepositoriesService implements ExternalApiGetService {

    @Inject
    GetGithubRepoBranchService getGithubRepoBranchService;

    @Inject
    GetGithubUsersService getGithubUsersService;

    @Override
    public RepositoriesUser getRepositoriesForUser(String username) {
        GithubRepositories userRepositories = getGithubUsersService.invoke(username)
                .getOnlyNotForkRepos();

        List<RepositoryUser> list = userRepositories.getGithubRepositoryList().stream()
                .map(repo -> GithubUser.toModel(GithubUser.builder()
                        .username(username)
                        .repoName(repo.getRepoName())
                        .branches(getGithubRepoBranchService.invoke(username, repo.getRepoName()))
                        .build())
                ).toList();

        return new RepositoriesUser(username,list);
    }
}
