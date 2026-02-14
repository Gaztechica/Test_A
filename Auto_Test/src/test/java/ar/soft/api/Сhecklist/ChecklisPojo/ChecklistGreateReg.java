package ar.soft.api.Сhecklist.ChecklisPojo;

import java.util.ArrayList;

public class ChecklistGreateReg {

    public class CategoryDtoList {
        public int number;
        public String name;
        public String description;
        public int checkListId;
        public Object parentCategoryNumber;
        public ArrayList<Object> descendantCategoriesId;
        public String status;
        public ArrayList<Object> links;

        public CategoryDtoList() {
        }

        public CategoryDtoList(int number, String name, String description, int checkListId, Object parentCategoryNumber, ArrayList<Object> descendantCategoriesId, String status, ArrayList<Object> links) {
            this.number = number;
            this.name = name;
            this.description = description;
            this.checkListId = checkListId;
            this.parentCategoryNumber = parentCategoryNumber;
            this.descendantCategoriesId = descendantCategoriesId;
            this.status = status;
            this.links = links;
        }

        public int getNumber() {
            return number;
        }

        public void setNumber(int number) {
            this.number = number;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public int getCheckListId() {
            return checkListId;
        }

        public void setCheckListId(int checkListId) {
            this.checkListId = checkListId;
        }

        public Object getParentCategoryNumber() {
            return parentCategoryNumber;
        }

        public void setParentCategoryNumber(Object parentCategoryNumber) {
            this.parentCategoryNumber = parentCategoryNumber;
        }

        public ArrayList<Object> getDescendantCategoriesId() {
            return descendantCategoriesId;
        }

        public void setDescendantCategoriesId(ArrayList<Object> descendantCategoriesId) {
            this.descendantCategoriesId = descendantCategoriesId;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public ArrayList<Object> getLinks() {
            return links;
        }

        public void setLinks(ArrayList<Object> links) {
            this.links = links;
        }
    }


    public class Root {
        public int authorId;
        public String name;
        public boolean isFlat;
        public ArrayList<CategoryDtoList> categoryDtoList;

        public Root() {
        }

        public Root(int authorId, String name, boolean isFlat, ArrayList<CategoryDtoList> categoryDtoList) {
            this.authorId = authorId;
            this.name = name;
            this.isFlat = isFlat;
            this.categoryDtoList = categoryDtoList;
        }

        public int getAuthorId() {
            return authorId;
        }

        public void setAuthorId(int authorId) {
            this.authorId = authorId;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public boolean isFlat() {
            return isFlat;
        }

        public void setFlat(boolean flat) {
            isFlat = flat;
        }

        public ArrayList<CategoryDtoList> getCategoryDtoList() {
            return categoryDtoList;
        }

        public void setCategoryDtoList(ArrayList<CategoryDtoList> categoryDtoList) {
            this.categoryDtoList = categoryDtoList;
        }
    }

    public ChecklistGreateReg() {
    }


}
