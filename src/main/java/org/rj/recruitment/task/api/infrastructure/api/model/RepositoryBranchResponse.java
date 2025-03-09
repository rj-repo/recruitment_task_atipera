package org.rj.recruitment.task.api.infrastructure.api.model;

import lombok.*;
import org.rj.recruitment.task.api.domain.model.RepositoryBranch;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RepositoryBranchResponse {
    private String branchName;
    private String lastCommitSHA;

    public static RepositoryBranchResponse of(RepositoryBranch repositoryBranch){
        return RepositoryBranchResponse.builder()
                .branchName(repositoryBranch.getBranchName())
                .lastCommitSHA(repositoryBranch.getLastCommitSHA())
                .build();
    }
}
