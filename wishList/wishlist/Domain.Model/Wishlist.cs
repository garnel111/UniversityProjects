using System.Collections.Generic;
using System.Linq;

namespace Farfetch.wishlist.Domain.Model
{
    public class Wishlist : AuditableDomainEntity
    {

        public int ExternalId { get; set; }
        public int OwnerId { get; set; }
        public List<WishlistItem> Items { get; set; }
        public Wishlist(List<WishlistItem> Items)
        {
            this.Items = new List<WishlistItem>();
        }

        public Wishlist()
        {

        }
        public Wishlist(int ExternalId, int OwnerId, List<WishlistItem> Items)
        {
            this.ExternalId = ExternalId;
            this.OwnerId = OwnerId;
            this.Items = Items;
        }

        public void AddOrUpdateWishlistItem(WishlistItem item)
        {

            if (!Items.Any(item1 => item1.WishlistItemId == item.WishlistItemId))
            {
                Items.Add(item);
                return;
            }
            int id = item.WishlistItemId;

            var itemFoundList = RetrieveItem(item);

            var itemRetrieved = getItem(itemFoundList);

            if (itemRetrieved != null)
            {
                Items.Remove(item);
                Items.Add(itemRetrieved);
            }

        }

        private WishlistItem getItem(List<WishlistItem> itemFoundList)
        {
            WishlistItem[] itemList = itemFoundList.ToArray();
            if (itemList.Length == 1)
            {
                return itemList[0];
            }
            return null;
        }

        private List<WishlistItem> RetrieveItem(WishlistItem item)
        {
            return (from it in Items
                    where (it.ExternalId.Equals(item.ExternalId))
                    select it).ToList();

        }

        public override string ToString()
        {
            foreach (var item in Items)
            {
                System.Console.WriteLine(" item: " + item.ToString() +  "\n item id: " + item.Id.ToString() + "\n itemName: " + item.Name.ToString());
                //System.Console.WriteLine(item.Id.ToString());
                //System.Console.WriteLine(item.Name.ToString());

            }
            return null;
        }

        public override bool Equals(object obj)
        {
            var objCasted = (Wishlist)obj;
            return this.ExternalId == objCasted.ExternalId && this.OwnerId == objCasted.OwnerId;

        }

        public override int GetHashCode()
        {
            return base.GetHashCode();
        }

        public WishlistItem GetWishListItemById(int v)
        {
            foreach (var item in Items)
            {
                if (item.Id == v)
                {
                    return item;
                }
            }
            return null;
        }
    }

}

