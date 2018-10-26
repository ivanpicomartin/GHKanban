package com.ghkanban.ghkanban;


public interface BasePresenter<T> {

    /**
     * Get presenter view reference
     *
     * @param view the view associated with this presenter
     */
    void takeView(T view);

    /**
     * Drops the reference to the view
     */
    void dropView();

}
