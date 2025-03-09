package org.rj.recruitment.task.api.domain.model;

import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RepositoryUser {
    private String repoName;
    private List<RepositoryBranch> branches;


}
