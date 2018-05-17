package com.eleicao.services;

import com.eleicao.interfaces.IRegistradorEleicao;
import com.eleicao.model.Candidato;
import com.eleicao.model.Urna;
import com.google.common.base.Functions;
import com.google.common.collect.Ordering;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class RegistradorEleicao implements IRegistradorEleicao {

    private static HashMap<String, Integer> votos = new HashMap<>();
    private static int numeroUrna = 1;
    private JTable jTable;

    public RegistradorEleicao(JTable jTable) {
        this.jTable = jTable;
    }

    @Override
    public List<Candidato> getListaDeCandidatos() throws RemoteException {
        List<Candidato> candidatos = new ArrayList<>();
        candidatos.add(new Candidato("Fabricio"));
        candidatos.add(new Candidato("José"));
        candidatos.add(new Candidato("Maria"));
        candidatos.add(new Candidato("Caroline"));
        return candidatos;
    }

    @Override
    public void registrarVoto(Candidato candidato, Urna urna) throws RemoteException {
        int totalVotos;
        if (votos.get(candidato.getNome()) == null) {
            totalVotos = 0;
        } else {
            totalVotos = votos.get(candidato.getNome());
            votos.remove(candidato.getNome());
        }
        totalVotos = totalVotos + 1;
        System.out.println(totalVotos);
        votos.put(candidato.getNome(), totalVotos);
        this.atualizaVotos();
    }

    @Override
    public HashMap<String, Integer> getVotos() throws RemoteException {
        Ordering<String> valueComparator = Ordering.natural().onResultOf(Functions.forMap(votos));
        return valueComparator.;
    }

    @Override
    public Urna getNumeroUrna() throws RemoteException {
        return new Urna("Nº:" + (numeroUrna++));
    }

    private void atualizaVotos() throws RemoteException {
        DefaultTableModel model = (DefaultTableModel) this.jTable.getModel();

        model.getDataVector().removeAllElements();
        model.fireTableDataChanged();

        for (Map.Entry<String, Integer> voto : this.getVotos().entrySet()) {
            String nome = voto.getKey();
            String totalVotos = voto.getValue().toString();
            model.addRow(new String[]{nome, totalVotos});
        }
    }


}
