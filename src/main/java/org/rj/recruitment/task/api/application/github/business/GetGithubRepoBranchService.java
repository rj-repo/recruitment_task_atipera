package org.rj.recruitment.task.api.application.github.business;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.rj.recruitment.task.api.application.github.repository.GithubRestClient;
import org.rj.recruitment.task.api.application.github.repository.model.GithubRepositoryBranch;

import java.util.List;

@ApplicationScoped
public class GetGithubRepoBranchService {

    @RestClient
    @Inject
    GithubRestClient githubRestClient;

    public List<GithubRepositoryBranch> invoke(String username, String branch) {
        return githubRestClient.getRepositoryBranches(username, branch);
    }
}
