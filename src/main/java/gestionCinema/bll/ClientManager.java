package gestionCinema.bll;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import gestionCinema.bo.Client;
import gestionCinema.dao.ClientDAOJDCImpl;

@Service
@Primary
public class ClientManager extends CrudManager<Client,ClientDAOJDCImpl> {


}
