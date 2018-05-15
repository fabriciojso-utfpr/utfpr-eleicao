
package com.eleicao.interfaces;

import com.eleicao.model.Candidato;
import com.eleicao.model.Urna;
import java.util.List;


interface IRegistradorEleicao {
    
    public List<Candidato> getListaDeCandidatos();
    public void registrarVoto(Candidato candidato, Urna urna);
}
