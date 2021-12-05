package refactoring_guru.iterator.example.iterators;

import refactoring_guru.iterator.example.profile.Profile;
import refactoring_guru.iterator.example.social_networks.WeiBo;

import java.util.Date;
import java.util.List;

/**
 * @author thomstrong
 */
public class WeiBoIterator implements ProfileIterator {
    private WeiBo network;
    private String type;
    private String userEmail;
    private int currentPosition = 0;
    private List<String> emailCache;
    private Date timeout;

    public WeiBoIterator(WeiBo network, String type, String email) {
        this.network = network;
        this.type = type;
        this.userEmail = email;
    }

    private void refreshCache() {
        if (this.emailCache == null || this.emailCache.isEmpty() || this.timeout.before(new Date(System.currentTimeMillis()))) {
            this.emailCache = this.network.requestRelatedContactsFromWeiboAPI(this.userEmail, this.type);
            this.timeout = new Date(System.currentTimeMillis() + 60000);
        }
    }

    @Override
    public boolean hasNext() {
        this.refreshCache();
        return this.currentPosition < this.emailCache.size();
    }

    @Override
    public Profile getNext() {
        if (!this.hasNext()) {
            return null;
        }
        String nextEmail = this.emailCache.get(this.currentPosition);
        this.currentPosition += 1;
        return this.network.requestContactInfoFromWeiboAPI(nextEmail);
    }

    @Override
    public void reset() {
        this.currentPosition = 0;
        this.emailCache = null;
    }
}
