package Program;

import java.util.List;

import model.dao.DAO;
import model.dao.impl.DaoFactory;
import model.entities.CartaDeApoio;

public class test {
    public static void main(String[] args) {

        CartaDeApoio cc = new CartaDeApoio(null, "Yuri", "Main Texto da Carta");
        DAO<CartaDeApoio> ccDao = DaoFactory.createCartaApoioDao();

        System.out.println("TESTE 1 - INSERT");
        ccDao.insert(cc);

        System.out.println("TESTE 2 - FindById");
        cc = ccDao.findById(1);
        System.out.println(cc);

        System.out.println("TESTE 3 - FindAll");
        List<CartaDeApoio> list = ccDao.findAll();

        for (CartaDeApoio ccd : list) {
            System.out.println(ccd);
        }

        System.out.println("TESTE 4 - DeleteById");
        cc = ccDao.findById(3);
        ccDao.deleteById(3);

        System.out.println("TESTE 5 - UPDATE");
        cc = ccDao.findById(4);
        cc.setNomeEscritor("Xablaummmm");
        ccDao.update(cc);
    }
}
