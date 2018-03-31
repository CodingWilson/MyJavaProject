package Pattern.FlyweightPattern.WithOutDesign;

import lombok.Data;

@Data
public class AuthorizationModel {
    private String user;
    private String securityEntity;
    private String permit;
}
