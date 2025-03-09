package org.rj.recruitment.task.api.infrastructure.api.model;

import lombok.*;
import org.rj.recruitment.task.api.domain.model.RepositoryUser;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RepositoryUserResponse {
    private String repoName;
    private List<RepositoryBranchResponse> branches;


    public static RepositoryUserResponse of(RepositoryUser repositoryUser){
        return RepositoryUserResponse.builder()
                .repoName(repositoryUser.getRepoName())
                .branches(repositoryUser.getBranches().stream().map(RepositoryBranchResponse::of).collect(Collectors.toList()))
                .build();
    }


}
