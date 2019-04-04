using Farfetch.wishlist.Application.DTO;
using System.Collections.Generic;

namespace Farfetch.wishlist.Application.Services.Interfaces
{
    public interface IWishlistService
    {
        WishlistDTO AddWishlist(WishlistDTO wishlistDTO);

        WishlistDTO GetWishlistA(int wishlistID);

        IEnumerable<WishlistDTO> GetWishlist(int wishlistID);

        void DeleteWishlist(int wishlistID);
       // WishlistDTO GetAll();
        List<WishlistDTO> GetAll();
    }
}
