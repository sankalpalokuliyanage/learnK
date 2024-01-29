// GrammarModel.java

package com.example.learnkorean.models;

import java.util.List;

public class GrammarModel {
    private String grammarName;
    private List<TitleModel> titles;

    public GrammarModel() {
        // Required empty public constructor
    }

    public GrammarModel(String grammarName, List<TitleModel> titles) {
        this.grammarName = grammarName;
        this.titles = titles;
    }

    public String getGrammarName() {
        return grammarName;
    }

    public void setGrammarName(String grammarName) {
        this.grammarName = grammarName;
    }

    public List<TitleModel> getTitles() {
        return titles;
    }

    public void setTitles(List<TitleModel> titles) {
        this.titles = titles;
    }

    public static class TitleModel {
        private String description;
        private String titleName;

        public TitleModel() {
            // Required empty public constructor
        }

        public TitleModel(String description, String titleName) {
            this.description = description;
            this.titleName = titleName;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getTitleName() {
            return titleName;
        }

        public void setTitleName(String titleName) {
            this.titleName = titleName;
        }
    }
}
