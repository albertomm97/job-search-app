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
  if (filter.id) {
    // Get jobs from db
    localStorage.setItem('jobs-offered', JSON.stringify(jobs));
    return jobs;
  }
};

const getJobById = (filter = {}) => {
  if (!filter.id) return null;

  const localJobs = JSON.parse(localStorage.getItem('jobs-offered'));

  if (localJobs) {
    return localJobs.find((job) => job.id === filter.id);
  }

  return jobs.find((job) => job.id === filter.id);
};

export { getJobsOffered, getJobById };
