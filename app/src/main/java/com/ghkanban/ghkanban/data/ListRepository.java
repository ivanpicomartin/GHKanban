package com.ghkanban.ghkanban.data;

import java.util.ArrayList;
import java.util.List;

public class ListRepository extends ArrayList {

    private List<RepositoryObject> repositoryObjectList;

    public List<RepositoryObject> getRepositoryObjectList() {
        return repositoryObjectList;
    }

    public void setRepositoryObjectList(List<RepositoryObject> repositoryObjectList) {
        this.repositoryObjectList = repositoryObjectList;
    }

    @Override
    public String toString() {
        return "ListRepository{" +
                "repositoryObjectList=" + repositoryObjectList +
                '}';
    }
}
