package com.wcs.heroSpring.heroSpring.utils;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.wcs.heroSpring.heroSpring.entities.Hero;
import com.wcs.heroSpring.heroSpring.repositories.HeroDao;


@Component
public class Outputter implements CommandLineRunner {

    private Logger LOG = LoggerFactory.getLogger("Superhero");

    @Autowired
    private HeroDao heroDao;

    @Override
    public void run(String... args) throws Exception {

        // Checke combien d'objets se trouvent dans la BDD        
        LOG.info("******************");
        LOG.info("Objects in DB : " + heroDao.count());

        // Crée un nouvel utilisateur et l'enregistre dans la BDD
        Hero hero1 = new Hero("Spiderman",756,"Marvel");
        LOG.info("******************");
        LOG.info(hero1 + " has been created !");
        heroDao.save(hero1);
        LOG.info(hero1 + " has been saved !");

        // Crée un second utilisateur et l'enregistre dans la BDD
        Hero hero2 = new Hero("Batman", 798, "DC Comics");
        LOG.info("******************");
        LOG.info(hero2 + " has been created !");
        heroDao.save(hero2);
        LOG.info(hero2 + " has been saved !");

        // Lit les informations correspondant au second utilisateur
        Hero tempHero = heroDao.findById(2L).get(); /* On écrit "2L" car 
                                                       le type de l'id est Long */
        LOG.info("******************");
        LOG.info("Second hero's name is " + tempHero.getName());
        LOG.info("Second hero's power is " + tempHero.getPower());
        LOG.info("Second hero's comics is " + tempHero.getComics());

        // Liste les utilisateurs enregistrés dans la BDD
        LOG.info("******************");
        LOG.info("Heroes in list are ");
        for(Hero myHero : heroDao.findAll()) {
            LOG.info(myHero.toString());
        };

        // Supprime le second utilisateur de la BDD
        heroDao.deleteById(2L); /* risque de provoquer une erreur si 
                                tu n'as pas vidé ta table avant de relancer 
                                ton application ! */

        /*     Liste les utilisateurs enregistrés dans la BDD
             (permet de vérifier que le second utilisateur
             a bien été supprimé de la BDD) */
        LOG.info("******************");
        LOG.info("Heroes in list are ");
        for(Hero myHero : heroDao.findAll()) {
            LOG.info(myHero.toString());
        };
    }    
}