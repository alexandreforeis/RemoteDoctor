package martinsreis.remotedoctor;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

/**
 * Created by felip on 03/09/2017.
 */

public interface APIService {

    @POST("/paciente/login")
    Call<PacienteModel> login(@Body LoginRequest body);

    @POST("/paciente/historico")
    Call<PacienteModel> enviarHistorico(@Body HistoricoRequest body);

}
