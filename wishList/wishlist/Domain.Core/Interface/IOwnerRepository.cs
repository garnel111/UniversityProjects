using Farfetch.wishlist.Domain.Model;

namespace Farfetch.wishlist.Data.Repository
{
    public interface IOwnerRepository
    {
        bool AddOwner(int id);
        bool UpdateOwner( Owner owner);
        Owner GetOwner(Owner owner);
        bool DeleteOwner(Owner owner);

        Wishlist GetWishlist(int id);
       
    }
}