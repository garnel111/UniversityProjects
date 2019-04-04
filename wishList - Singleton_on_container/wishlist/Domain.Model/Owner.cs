using System.Collections.Generic;

namespace Farfetch.wishlist.Domain.Model
{
    public class Owner : AuditableDomainEntity
    {
        private Wishlist wlist;

        private List<Wishlist> WishlistList;
        public int ExternalId { get; set; }

        public string Name { get; set; }
        public Owner()
        {
            this.WishlistList = new List<Wishlist>();
        }
        public Owner(int ExternalId, string name) : this()

        {

            this.ExternalId = ExternalId;
            this.Name = name;


        }
        public Owner(int ExternalId) : this()

        {

            this.ExternalId = ExternalId;



        }
        public ICollection<Wishlist> Wishlists { get; set; }
        public void AddWishlist(Wishlist Wishlist)
        {

            Wishlists.Add(Wishlist);

        }

        //???????? dúvidas
        public Wishlist GetOrCreateWishlist(Wishlist Wishlist)
        {
            if (Wishlist == null)
            {
                return Wishlist = new Wishlist();

            }

            return Wishlist;
        }


        //método owner??

        public void RemoveWihsList(Wishlist Wishlist)
        {
            Wishlists.Remove(Wishlist);
        }
    }
}
