package org.rj.recruitment.task.api.domain.model;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RepositoryBranch {
    private String branchName;
    private String lastCommitSHA;
}
