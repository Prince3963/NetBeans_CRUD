/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package com.Controller;

import com.Entity.GitTbl;
import comModel.GitTblFacade;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;

/**
 *
 * @author ASUS
 */
@Named(value = "login")
@SessionScoped


public class Login implements Serializable {

    @EJB
    private GitTblFacade gitTblFacade;
    private GitTbl gitTbl= new GitTbl();

    public GitTblFacade getGitTblFacade() {
        return gitTblFacade;
    }

    public void setGitTblFacade(GitTblFacade gitTblFacade) {
        this.gitTblFacade = gitTblFacade;
    }

    public GitTbl getGitTbl() {
        return gitTbl;
    }

    public void setGitTbl(GitTbl gitTbl) {
        this.gitTbl = gitTbl;
    }
    

    /**
     * Creates a new instance of Login
     */
    public Login() {
    }
    
    public List<GitTbl> Login(){
    
        return this.gitTblFacade.findAll();    
    }
    
    public String insert(){
        this.gitTblFacade.create(gitTbl);
        return "index";
    }
    
    public String update(GitTbl gt){
        this.gitTbl=gt;
        return "update";
    }
    public String preupdate(){
        this.gitTblFacade.edit(gitTbl);
        this.gitTbl = new GitTbl();
        return "index"; //use in update
    }
    
    public String delete( GitTbl gt){
        this.gitTblFacade.remove(gt);
        return "index";
    }
}
