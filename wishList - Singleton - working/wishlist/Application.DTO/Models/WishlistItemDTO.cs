

using Farfetch.wishlist.Domain.Model;

namespace Farfetch.wishlist.Application.DTO
{
    public   class WishlistItemDTO
    {
        public int Code { get; set; }
        public string Name { get; set; }
        public float Price { get; set; }
        public int WishlistItemId { get; set; }
        public Wishlist Wishlist { get; set; }
    }
}
