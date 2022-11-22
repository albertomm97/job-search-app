const jobs = [
  {
    id: '1',
    title: 'title',
    companyName: 'companyName',
    place: 'Valencia',
    uploadDate: '21/02/2023',
    description:
      'KJAKLSJDKLSAJDKLAJSDK kajdk sjkdj akjd kajd kjakjd kja KJAKLSJDKLSAJDKLAJSDK kajdk sjkdj akjd kajd kjakjd kja KJAKLSJDKLSAJDKLAJSDK kajdk sjkdj akjd kajd kjakjd kja',
    email: 'company@gmail.com',
    type: 'Full Remote',
    category: 'Full Stack',
    experience: '1',
    salary: '25000',
    studies: 'Degree',
    profilePicture: '',
  },
  {
    id: '2',
    title: 'title2',
    companyName: 'companyName2',
    place: 'Valencia2',
    uploadDate: '21/02/2023',
    description:
      'KJAKLSJDKLSAJDKLAJSDK kajdk sjkdj akjd kajd kjakjd kja KJAKLSJDKLSAJDKLAJSDK kajdk sjkdj akjd kajd kjakjd kja KJAKLSJDKLSAJDKLAJSDK kajdk sjkdj akjd kajd kjakjd kja',
    email: 'company@gmail.com',
    type: 'Full Remote',
    category: 'Full Stack',
    experience: '1',
    salary: '25000',
    studies: 'Degree',
    profilePicture: '',
  },
];

const getJobsOffered = (filter = {}) => {
  const jsonOffers = localStorage.getItem('jobsOffered');

  let offers = null;
  let desiredOffer = null;
  if (jsonOffers && filter.id) {
    offers = JSON.parse(jsonOffers);
    //console.log(`Offers: ${offers}`);
    desiredOffer = offers.find((offer) => offer.id === filter.id);

    if (desiredOffer) return desiredOffer;
    //console.log(`Desired offer: ${desiredOffer}`);
  }

  if (filter.id) {
    return jobs.find((offer) => offer.id === filter.id);
  } else if (Object.keys(filter).length === 0) {
    return jobs;
  } else {
    // apply filter
  }
};

export { getJobsOffered };
