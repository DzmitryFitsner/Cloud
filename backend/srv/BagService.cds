using Bag as _Bag from '../db/Bag';
using Address as _Address from '../db/BagInfo';
using Laptops as _Laptops from '../db/BagInfo';

service odata {

  entity Bags @(
		title: 'Bags',
		Capabilities: {
			InsertRestrictions: {Insertable: false},
			UpdateRestrictions: {Updatable: false},
			DeleteRestrictions: {Deletable: false}
		}
	) as projection on _Bag;

  entity Address @(
		title: 'Address',
		Capabilities: {
			InsertRestrictions: {Insertable: false},
			UpdateRestrictions: {Updatable: false},
			DeleteRestrictions: {Deletable: false}
		}
	) as projection on _Address;

    entity Laptops @(
		title: 'Laptops',
		Capabilities: {
			InsertRestrictions: {Insertable: false},
			UpdateRestrictions: {Updatable: false},
			DeleteRestrictions: {Deletable: false}
		}
	) as projection on _Laptops;

}
