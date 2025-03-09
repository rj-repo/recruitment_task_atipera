package org.rj.recruitment.task.api.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class RepositoriesUser {
    private String username;
    private List<RepositoryUser> repositoryUserList;
}
