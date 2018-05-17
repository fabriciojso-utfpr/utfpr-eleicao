
package com.eleicao.interfaces;

import com.eleicao.model.Candidato;
import com.eleicao.model.Urna;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.HashMap;
import java.util.List;


public interface IRegistradorEleicao extends Remote {
    
    public List<Candidato> getListaDeCandidatos() throws RemoteException;
    public void registrarVoto(Candidato candidato, Urna urna) throws RemoteException;
    public HashMap<String, Integer> getVotos() throws RemoteException;
    public Urna getNumeroUrna() throws RemoteException;
}
