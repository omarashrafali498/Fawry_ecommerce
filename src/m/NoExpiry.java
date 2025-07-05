package m;

public class NoExpiry implements Expirable {
    @Override
    public boolean isExpired() {
        return false;
    }
}