using Farfetch.wishlist.Application.DTO;

namespace Farfetch.wishlist.Application.Services.Interfaces
{
    public interface IOwnerService
    {
        OwnerDTO GetOwner(OwnerDTO owner);

        bool UpdateOwner(OwnerDTO owner);

        bool DeleteOwner(OwnerDTO owner);

        bool AddOwner(OwnerDTO owner);
        OwnerDTO GetWishlists(int id);
       
    }
}
