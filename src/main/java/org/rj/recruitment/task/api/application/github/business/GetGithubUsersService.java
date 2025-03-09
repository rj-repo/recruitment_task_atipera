package org.rj.recruitment.task.api.application.github.business;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.rj.recruitment.task.api.application.github.repository.GithubRestClient;
import org.rj.recruitment.task.api.application.github.repository.model.GithubRepositories;

@ApplicationScoped
public class GetGithubUsersService {

    @RestClient
    @Inject
    GithubRestClient githubRestClient;


    public GithubRepositories invoke(String username) {
        return new GithubRepositories(githubRestClient.getUserRepositories(username));
    }
}
