package Pattern.FlyweightPattern.WithOutDesign;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class SecurityMgr {
    private static SecurityMgr securityMgr = new SecurityMgr();
    private SecurityMgr() {
    }

    public static SecurityMgr getInstance() {
        return securityMgr;
    }

    private Map<String, Collection<AuthorizationModel>> map = new HashMap<>();

    public void login(String user) {
        Collection<AuthorizationModel> col = queryByUser(user);
        map.put(user, col);
    }

    public boolean hasPermit(String user, String securityEntity, String permit) {
        Collection<AuthorizationModel> col = map.get(user);
        if(col == null || col.isEmpty()) {
            System.out.println(user + "没有权限");
            return false;
        }

        for (AuthorizationModel authorizationModel : col) {
            System.out.println("am" + authorizationModel);
            if (authorizationModel.getSecurityEntity().equals(securityEntity)
                    && authorizationModel.getPermit().equals(permit)) {
                return true;
            }
        }
        return false;
    }


    private Collection<AuthorizationModel> queryByUser(String user) {
        Collection<AuthorizationModel> col = new ArrayList<>();
        for (String s : TestDB.colDB) {
            String[] ss = s.split(",");
            if (ss[0].equals(user)) {
                AuthorizationModel authorizationModel = new AuthorizationModel();
                authorizationModel.setUser(ss[0]);
                authorizationModel.setSecurityEntity(ss[1]);
                authorizationModel.setPermit(ss[2]);

                col.add(authorizationModel);
            }
        }

        return col;
    }
}
