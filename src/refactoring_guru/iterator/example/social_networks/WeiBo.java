package refactoring_guru.iterator.example.social_networks;

import refactoring_guru.iterator.example.iterators.ProfileIterator;
import refactoring_guru.iterator.example.iterators.WeiBoIterator;
import refactoring_guru.iterator.example.profile.Profile;

import java.util.ArrayList;
import java.util.List;

/**
 * @author thomstrong
 */
public class WeiBo implements SocialNetwork{
    private List<Profile> allUserProfiles;

    public WeiBo(List<Profile> cache) {
        if (cache != null) {
            this.allUserProfiles = cache;
        } else {
            this.allUserProfiles = new ArrayList<>();
        }
    }

    public Profile requestContactInfoFromWeiboAPI(String profileEmail) {
        simulateNetworkLatency();
        System.out.println("Weibo: Loading profile '" + profileEmail + "' over the network...");

        return findContact(profileEmail);
    }

    public List<String> requestRelatedContactsFromWeiboAPI(String profileEmail, String contactType) {
        simulateNetworkLatency();
        System.out.println("Weibo: Loading '" + contactType + "' list of '" + profileEmail + "' over the network...");

        Profile profile = findContact(profileEmail);
        if (profile != null) {
            return profile.getContacts(contactType);
        }
        return null;
    }

    private Profile findContact(String profileEmail) {
        for (Profile profile : allUserProfiles) {
            if (profile.getEmail().equals(profileEmail)) {
                return profile;
            }
        }
        return null;
    }

    private void simulateNetworkLatency() {
        try {
            Thread.sleep(2500);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }


    @Override
    public ProfileIterator createFriendsIterator(String profileEmail) {
        return new WeiBoIterator(this, "friends", profileEmail);
    }

    @Override
    public ProfileIterator createCoworkersIterator(String profileEmail) {
        return new WeiBoIterator(this, "coworker", profileEmail);
    }
}
