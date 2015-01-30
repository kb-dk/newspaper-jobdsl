import javaposse.jobdsl.dsl.Job
import javaposse.jobdsl.dsl.JobType

Job mavenJob = job(type: JobType.Maven) {}
NewspaperUtilities.addCommonSteps(mavenJob);

mavenJob.with {
    name 'newspaper-prompt-doms-ingester'
    scm {
        git {
            remote {
                url('https://github.com/statsbiblioteket/newspaper-prompt-doms-ingester')
            }
            branch('master')
        }
    }
    postBuildSteps {
        shell("ssh newspapr@achernar \"source .bash_profile ; ~/deploy-scripts/deploy-doms-ingester.sh")
    }
    blockOn("achernar-ingest-metadata")
}


Job achernarJob = job(type: JobType.Freeform) {}
NewspaperUtilities.addAchernar(achernarJob)

achernarJob.with {
    name 'achernar-ingest-metadata'
    steps {
        shell('set +e;\n' +
                'set +x;\n' +
                'ssh newspapr@achernar "source .bash_profile ; shopt -s huponexit; mkdir ~/cibuild; cd ~/cibuild; newspaper-prompt-doms-ingester-*/bin/start_prompt_ingest_component.sh </dev/null"')
    }
    blockOn(mavenJob.name)
}
